[![Build Status](https://api.travis-ci.org/wi101/embroidery.svg?branch=master)](https://travis-ci.org/wi101/embroidery)

# embroidery

You can add an artistic touch to your console.

## Usage

This is an example usage:

1. Convert your text to ASCII Art:

```
import embroidery.asciiArt.titles._
printWithSimpleArt("Hello world", '#')
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
import embroidery.asciiArt.logos._
printWithArt("src/test/scala/embroidery/asciiArt/logos/images/scalaz.png")
```

| scalaz.png | result with ASCII Art |
| --- | --- |
|![scalaz](https://user-images.githubusercontent.com/3535357/38699500-7d284c48-3e98-11e8-9cc4-bc359a35a7f0.png)| <img width="321" alt="capture d ecran 2018-04-12 a 21 26 53" src="https://user-images.githubusercontent.com/3535357/38699434-47dfbce2-3e98-11e8-9419-a78699264622.png">|



```
import embroidery.asciiArt.logos._
printWithArt("src/test/scala/embroidery/asciiArt/logos/images/scala.jpg")
```
| scala.jpg | result with ASCII Art |
| --- | --- |
| ![logo](https://user-images.githubusercontent.com/3535357/36055500-2611c978-0dfd-11e8-8ca4-15c689fa0438.jpg)|<img width="724" alt="capture d ecran 2018-04-12 a 21 26 27" src="https://user-images.githubusercontent.com/3535357/38699716-1a383584-3e99-11e8-9172-7b7597a71b67.png">|


