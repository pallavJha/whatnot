package main

import (
	b32 "encoding/base32"
	"fmt"
	"github.com/pquerna/otp"
	"github.com/pquerna/otp/totp"
	"io/ioutil"
	"net/http"
	"strings"
	"time"
)

func main() {
	data := "pallav_kumar71@yahoo.com" + "HENNGECHALLENGE003"
	sEnc := b32.StdEncoding.EncodeToString([]byte(data))
	fmt.Println(sEnc)


	passcode, err := totp.GenerateCodeCustom(sEnc, time.Now().UTC(), totp.ValidateOpts{
		Period:    30,
		Skew:      0,
		Digits:    otp.Digits(10),
		Algorithm: otp.AlgorithmSHA512,
	})

	if err != nil {
		panic(fmt.Sprintf("%s - %v", "error creating the key", err))
	}

	fmt.Println("Passcode", passcode)

	url := "https://api.challenge.hennge.com/challenges/003"
	method := "POST"

	payload := strings.NewReader(`{
	"github_url": "https://gist.github.com/pallavJha/02ad34e2c6576122b32cf03610033765",
	"contact_email": "pallav_kumar71@yahoo.com"
	}`)

	client := &http.Client{
	}
	req, err := http.NewRequest(method, url, payload)

	if err != nil {
		fmt.Println(err)
	}
	req.Header.Add("Content-Type", "application/json")
	req.SetBasicAuth("pallav_kumar71@yahoo.com", passcode)

	res, err := client.Do(req)
	if err != nil {
		panic(fmt.Sprintf("%s - %v", "error while client.Do", err))
	}
	defer func() {
		err := res.Body.Close()
		if err != nil {
			panic(fmt.Sprintf("%s - %v", "error while body close", err))
		}
	}()
	body, err := ioutil.ReadAll(res.Body)
	if err != nil {
		panic(fmt.Sprintf("%s - %v", "error while reading body", err))
	}
	fmt.Println(string(body))
}
