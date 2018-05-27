package pl.misc.interviewbit.two.pointers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/* Name of the class has to be "Main" only if the class is public. */
class NSLookUp
{
    public static void main (String[] args) throws java.lang.Exception
    {
        try {

            InetAddress inetHost = InetAddress.getByName("zproxy.lum-superproxy.io");
            String hostName = inetHost.getHostName();
            System.out.println("The host name was: " + hostName);
            System.out.println("The hosts IP address is: " + inetHost.getHostAddress());

        } catch(UnknownHostException ex) {
            System.out.println("Unrecognized host");
        }
    }
}
