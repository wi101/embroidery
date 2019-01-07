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
logo.printWithArt("src/test/scala/embroidery/asciiArt/logos/images/scalaz.png")
```

| scalaz.png | result with ASCII Art |
| --- | --- |
| ![scalaz](https://user-images.githubusercontent.com/3535357/38699500-7d284c48-3e98-11e8-9cc4-bc359a35a7f0.png) | ![scalaz](https://user-images.githubusercontent.com/3535357/50744067-73f17180-121f-11e9-8985-2c7186e28532.png) |



```
logo.printWithArt("src/test/scala/embroidery/asciiArt/logos/images/scala.jpg")
```
| scala.jpg | result with ASCII Art |
| --- | --- |
|![scala](https://user-images.githubusercontent.com/3535357/36055500-2611c978-0dfd-11e8-8ca4-15c689fa0438.jpg) | ![scala](https://user-images.githubusercontent.com/3535357/50744069-84095100-121f-11e9-84ca-ac3f2f5a17e0.png) |
