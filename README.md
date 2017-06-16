There are supposed to be 5 bytes returned:
0x00 = Humidity
0x01 = Humidity decimal places
0x02 = Temperature
0x03 = Temperature decimal places
0x04 = Checksum (sum 0x00,0x01,0x02,0x03)

Arduino example returns data like this:
45,6,24,0,75 - which means 45.6 %RH, 24.0 deg C, (valid checksum 45+6+24+0=75)
45,6,23,9,83 - which means 45.6 %RH, 23.9 deg C, (valid checksum 45+6+23+9=83)
45,7,23,9,84 - which means 45.7 %RH, 23.9 deg C, (valid checksum 45+7+23+9=84)



Checkout my YouTube channel for video on this and many more.

   Channel: bit.ly/2d8pHge
