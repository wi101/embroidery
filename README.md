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
You can specify the spaces between the character.
For example, e would like to display S c a l a, you can call:
```
title.printWithSimpleArt("Scala", art = 'S', spaced = Some(1))
```

Output:

```
                                SS                            
                                SS                            
 SSSS      SSSSS     SSSSS      SS     SSSSS                  
SSSSS     SSSSSS     SSSSS      SS     SSSSS                  
 SSS      SSS           SS      SS        SS                  
 SSSS     SSS        SSSSS      SS     SSSSS                  
  SSSS    SSS       SSS SS      SS    SSS SS                  
SS SSS    SSSSSS    SSSSSS      SS    SSSSSS                  
SSSSS      SSSSS    SSSSSSS     SS    SSSSSSS                 
  SS         SS       S  S              S  S                  
                                                    
```

If you would like to get the ascii art as a String and use it in different places, you can call:

```scala
import embroidery.asciiArt.title

val zio: String = title.asciiArt("ZIO", "*", spaced = Some(2))
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


You can get the Ascii Art of your icons as a string using:

```scala
import embroidery.asciiArt.logo

val zio: String = logo.asciiArt("image.png")
```
Note: The valid format of the pictures are: jpg, jpeg, png, bmp
