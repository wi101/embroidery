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
printWithArt("src/test/scala/embroidery/asciiArt/logos/images/logo.jpg")
```
### logo.png :

![logo](https://user-images.githubusercontent.com/3535357/36005601-b39bfa40-0d38-11e8-8c3d-7e19f5fcf00a.jpg)

### result with ASCII Art:

![logowithasciiart](https://user-images.githubusercontent.com/3535357/36005528-716912b6-0d38-11e8-815f-8e7eb4c9be14.png)

//TODO
