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

![logo](https://user-images.githubusercontent.com/3535357/36055500-2611c978-0dfd-11e8-8ca4-15c689fa0438.jpg)

### result with ASCII Art:

![logowithasciiart](https://user-images.githubusercontent.com/3535357/36055462-d5cdfa72-0dfc-11e8-9b2a-2eee695bbb1f.png)

//TODO
