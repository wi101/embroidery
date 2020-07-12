[![Build Status](https://api.travis-ci.org/wi101/embroidery.svg?branch=master)](https://travis-ci.org/wi101/embroidery)

# embroidery

You can add an artistic touch to your console.

## Usage

This is an example usage:

1. Convert your text to ASCII Art:

```
title.printWithSimpleArt("Hello world", '#')
```

Output:

```
 #     #         #  #           #    #    #            #      #
 #     #         #  #           #   # #   #            #      #
 #     #   ###   #  #   ###     #   # #  #   ###   # # #   ## #
 #     #  #   #  #  #  #   #     #  # #  #  #   #  ##  #  #  ##
 #######  #   #  #  #  #   #     # #   # #  #   #  #   #  #   #
 #     #  #####  #  #  #   #     # #   # #  #   #  #   #  #   #
 #     #  #      #  #  #   #     # #   # #  #   #  #   #  #   #
 #     #  #   #  #  #  #   #      #     #   #   #  #   #  #  ##
 #     #   ###   #  #   ###       #     #    ###   #   #   ## #

```

2. Convert your LOGO to ASCII Art:

```
logo.printWithArt("src/test/scala/embroidery/asciiArt/logos/images/pikachu.png")
```
| pikachu.png | result with ASCII Art |
| --- | --- |
| ![pikachu](https://user-images.githubusercontent.com/3535357/87250424-f0908c00-c464-11ea-9bb9-bc92b23ca63d.png) | ![pikachu](https://user-images.githubusercontent.com/3535357/87250405-d48cea80-c464-11ea-9ccc-ce13d4ef60dd.png) |

```
logo.printWithArt("src/test/scala/embroidery/asciiArt/logos/images/zio.png")
```
| zio.png | result with ASCII Art |
| --- | --- |
| ![zio](https://user-images.githubusercontent.com/3535357/87250611-49145900-c466-11ea-8f75-ccfacc4bae05.png) | ![zio](https://user-images.githubusercontent.com/3535357/87250628-7234e980-c466-11ea-87c1-ae82c09703ce.png) | 



```
logo.printWithArt("src/test/scala/embroidery/asciiArt/logos/images/scala.jpg")
```
| scala.jpg | result with ASCII Art |
| --- | --- |
|![scala](https://user-images.githubusercontent.com/3535357/36055500-2611c978-0dfd-11e8-8ca4-15c689fa0438.jpg) | ![scala](https://user-images.githubusercontent.com/3535357/87250678-d8ba0780-c466-11ea-9e4d-bd1b7de03119.png) |
