package main

import (
	"image"
	"image/color"
	"image/jpeg"
	"log"
	"os"
)

func main() {

	rgba1 := PrepareImage()
	rgba2 := PrepareImage()

	pixel1 := DecodePixelsFromImage(rgba1, 0, 0)
	pixel2 := DecodePixelsFromImage(rgba2, rgba1.Bounds().Max.X, 0)

	newPixels := append(pixel1, pixel2...)
	newRect := image.Rect(rgba1.Bounds().Min.X, rgba1.Bounds().Min.Y, rgba1.Bounds().Max.X + rgba2.Bounds().Max.X, rgba2.Bounds().Max.Y)
	newImage := image.NewNRGBA(newRect)

	for _, px := range newPixels {
		newImage.Set(
			px.Point.X,
			px.Point.Y,
			px.Color,
		)
	}

	emptyFile, err := os.Create("emptyFile.jpeg")
	if err != nil {
		log.Fatalf("error while creating the file: %v", err)
	}
	err = jpeg.Encode(emptyFile, newImage, nil)
	if err != nil {
		log.Fatalf("error while encoding the image: %v", err)
	}

	defer func() {
		err = emptyFile.Close()
		if err != nil {
			log.Fatalf("error while closing the file: %v", err)
		}
	}()
}

func PrepareImage() *image.NRGBA {
	var colorBounds = make([][]color.Color, 3)
	for i := range colorBounds {
		colorBounds[i] = make([]color.Color, 2)
		colorBounds[i][0] = color.Black
		colorBounds[i][1] = color.Black
	}

	colorBounds[0][0] = color.RGBA{
		R: 255,
		G: 0,
		B: 0,
		A: 255,
	}
	colorBounds[0][1] = color.RGBA{
		R: 0,
		G: 255,
		B: 0,
		A: 255,
	}
	colorBounds[1][0] = color.RGBA{
		R: 0,
		G: 0,
		B: 255,
		A: 255,
	}
	colorBounds[1][1] = color.RGBA{
		R: 255,
		G: 0,
		B: 255,
		A: 255,
	}
	colorBounds[2][0] = color.RGBA{
		R: 0,
		G: 255,
		B: 255,
		A: 255,
	}
	colorBounds[2][1] = color.RGBA{
		R: 255,
		G: 255,
		B: 0,
		A: 255,
	}

	rect := image.Rect(0, 0, 200, 300)
	rgba := image.NewNRGBA(rect)
	b := rgba.Bounds()
	for y := b.Min.Y; y < b.Max.Y; y++ {
		for x := b.Min.X; x < b.Max.X; x++ {
			rgba.Set(x, y, colorBounds[y/100][x/100])
		}
	}
	return rgba
}

// Create a struct to deal with pixel
type Pixel struct {
	Point image.Point
	Color color.Color
}

func DecodePixelsFromImage(img image.Image, offsetX, offsetY int) []*Pixel {
	pixels := []*Pixel{}
	for y := 0; y <= img.Bounds().Max.Y; y++ {
		for x := 0; x <= img.Bounds().Max.X; x++ {
			p := &Pixel{
				Point: image.Point{x + offsetX, y + offsetY},
				Color: img.At(x, y),
			}
			pixels = append(pixels, p)
		}
	}
	return pixels
}
