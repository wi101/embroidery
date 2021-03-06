# embroidery

You can add an artistic touch to your console.

To use embroidery, add the following line in your `build.sbt` file:
```
libraryDependencies += "com.github.wi101" %% "embroidery" % "0.1.1"
```

## Usage

1. Convert your text to ASCII Art:
`title.asciiArt` returns a String that you can display or use in your project.
 Or you can use the syntax `title.toAsciiArt`.

```scala
import embroidery.title

title.asciiArt("Hello world")
```

Or:

```scala
import embroidery._

"Hello".toAsciiArt
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
For example, if you would like to display S c a l a, you can call:
```scala
import embroidery.title

title.asciiArt("Scala", art = 'S', spaces = 1)
```
Or
```scala
import embroidery._

"Scala".toAsciiArt(art = 'S', spaces = 1)
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
WARNNG: The title should be short to be able to display it in your screen (maximum 20 characters including spaces).

2. Convert your LOGO to ASCII Art:

You can get the Ascii Art of your icons using `logo.asciiArt` method.
Or you can use the syntax `logoPath.toAsciiArt`.

```scala
import embroidery.logo

logo.asciiArt("src/test/scala/embroidery/asciiArt/logos/images/pikachu.png")
```

OR

```scala
import embroidery._

ImagePath("src/test/scala/embroidery/asciiArt/logos/images/pikachu.png").toAsciiArt
```
| pikachu.png | result with ASCII Art |
| --- | --- |
| ![pikachu](https://user-images.githubusercontent.com/3535357/87250424-f0908c00-c464-11ea-9bb9-bc92b23ca63d.png) | ![pikachu](https://user-images.githubusercontent.com/3535357/87250405-d48cea80-c464-11ea-9ccc-ce13d4ef60dd.png) |

```scala
import embroidery.logo

logo.asciiArt("src/test/scala/embroidery/asciiArt/logos/images/zio.png")
```

OR

```scala
import embroidery._

ImagePath("src/test/scala/embroidery/asciiArt/logos/images/zio.png").toAsciiArt
```

| zio.png | result with ASCII Art |
| --- | --- |
| ![zio](https://user-images.githubusercontent.com/3535357/87250611-49145900-c466-11ea-8f75-ccfacc4bae05.png) | ![zio](https://user-images.githubusercontent.com/3535357/87250628-7234e980-c466-11ea-87c1-ae82c09703ce.png) | 

```scala
import embroidery.logo

logo.asciiArt("src/test/scala/embroidery/asciiArt/logos/images/scala.jpg")
```

OR

```scala
import embroidery._

ImagePath("src/test/scala/embroidery/asciiArt/logos/images/scala.jpg").toAsciiArt
```

| scala.jpg | result with ASCII Art |
| --- | --- |
|![scala](https://user-images.githubusercontent.com/3535357/36055500-2611c978-0dfd-11e8-8ca4-15c689fa0438.jpg) | ![scala](https://user-images.githubusercontent.com/3535357/87250678-d8ba0780-c466-11ea-9e4d-bd1b7de03119.png) |

You can also decide which characters to use on each brightness level:

```scala
import embroidery._

 val pixelsWithArt: List[PixelAsciiArt] = List(
    PixelAsciiArt(Pixel(255), Art(' ')),
    PixelAsciiArt(Pixel(0), Art('#'))
  )

  val img: String = ImagePath("src/test/scala/embroidery/asciiArt/images/zio.png").toAsciiArt(pixelsWithArt)
  val s = img.flatMap(
    c =>
      if (c != ' ' && c != '\n')
        Console.RED + c.toString + Console.RESET
      else c.toString
  )
  println(s)
```

Output:

<img width="572" alt="Screen Shot 2020-07-25 at 3 52 02 PM" src="https://user-images.githubusercontent.com/3535357/88458511-d1472500-ce8e-11ea-92a2-0eb53dc9660c.png">

You can also control the size of your logo:

```scala
import embroidery._

  val pixelsWithArt: List[PixelAsciiArt] = List(
      PixelAsciiArt(Pixel(255), Art(' ')),
      PixelAsciiArt(Pixel(230), Art('.')),
      PixelAsciiArt(Pixel(220), Art(',')),
      PixelAsciiArt(Pixel(210), Art('°')),
      PixelAsciiArt(Pixel(200), Art('²')),
      PixelAsciiArt(Pixel(190), Art('*')),
      PixelAsciiArt(Pixel(180), Art('^')),
      PixelAsciiArt(Pixel(170), Art('~')),
      PixelAsciiArt(Pixel(150), Art('/')),
      PixelAsciiArt(Pixel(140), Art('|')),
      PixelAsciiArt(Pixel(130), Art('s')),
      PixelAsciiArt(Pixel(120), Art('q')),
      PixelAsciiArt(Pixel(90), Art('µ')),
      PixelAsciiArt(Pixel(70), Art('@')),
      PixelAsciiArt(Pixel(0), Art('#'))
    )

  val img = logo.asciiArt(
    "src/test/scala/embroidery/asciiArt/images/scala.jpg",
    pixelsWithArt,
    100,
    50
  )
// The same as: ImagePath("...").toAsciiArt(pixelsWithArt, 100, 50)
  val scala = img.flatMap(
    c =>
      if (c != ' ' && c != '\n')
        Console.RED + c.toString + Console.RESET
      else c.toString
  )
  println(scala)

```

Output:

<img width="1428" alt="Screen Shot 2020-07-25 at 4 29 18 PM" src="https://user-images.githubusercontent.com/3535357/88459305-9647f000-ce94-11ea-980a-777d61b984b3.png">


Note: The valid format of the pictures are: jpg, jpeg, png, bmp
