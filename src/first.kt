import kotlin.math.PI
import kotlin.math.sqrt
import kotlin.random.Random
import kotlin.system.exitProcess

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle(private val r: Double): Shape
{
    override fun calcArea(): Double {
        if(r<0) {
            println("error")
            exitProcess(400)
        }
        return r*r*PI
    }

    override fun calcPerimeter(): Double {
        if(r<0)
        {
            println("error")
            exitProcess(400)
        }
        return 2*r*PI
    }

}
/* implementation */
class Square(private val a: Double): Shape
{
    override fun calcArea(): Double {
        if(a<0) {
            println("error")
            exitProcess(400)
        }
        return a*a
    }

    override fun calcPerimeter(): Double {
        if(a<0) {
            println("error")
            exitProcess(400)
        }
        return a*4
    }

}

class Rectangle(private val a: Double, private val b: Double): Shape {
    override fun calcArea(): Double {
        if(a<0 || b<0) {
            println("error")
            exitProcess(400)
        }
        return a*b
    }

    override fun calcPerimeter(): Double {
        if(a<0 || b<0) {
            println("error")
            exitProcess(400)
        }
        return (a+b)*2
    }
}

class Triangle(private val a: Double, private val b: Double, private val c: Double): Shape {
    override fun calcArea(): Double {
        if(a<0 || b<0 || c<0) {
            println("error")
            exitProcess(400)
        }
        val perimeter = (a+b+c)/2
        val area = perimeter*(perimeter-a)*(perimeter-b)*(perimeter-c)
        return sqrt(area)
    }

    override fun calcPerimeter(): Double {
        if(a<0 || b<0 || c<0) {
            println("error")
            exitProcess(400)
        }
        return a+b+c
    }
}

interface ShapeFactory {
    fun createCircle(r: Double): Circle
    fun createSquare(a: Double): Square
    fun createRectangle(a: Double,b: Double): Rectangle
    fun createTriangle(a: Double,b: Double,c: Double): Triangle

    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle

    fun createRandomShape(): Shape
}

class ShapeFactoryImpl : ShapeFactory {
    /*  implementation */
    override fun createCircle(r: Double): Circle {
        return Circle(r)
    }

    override fun createSquare(a: Double): Square {
        return Square(a)
    }

    override fun createRectangle(a: Double, b: Double): Rectangle {
        return Rectangle(a,b)
    }

    override fun createTriangle(a: Double, b: Double, c: Double): Triangle {
        return Triangle(a,b,c)
    }

    override fun createRandomCircle(): Circle {
        val r = Random.nextDouble(0.1, 100.0)
        return Circle(r)
    }

    override fun createRandomSquare(): Square {
        val a = Random.nextDouble(0.1, 100.0)
        return Square(a)
    }

    override fun createRandomRectangle(): Rectangle {
        val a = Random.nextDouble(0.1, 100.0)
        val b = Random.nextDouble(0.1, 100.0)
        return Rectangle(a,b)
    }

    override fun createRandomTriangle(): Triangle {
        val a = Random.nextDouble(0.1, 100.0)
        val b = Random.nextDouble(0.1, 100.0)
        val c = Random.nextDouble(0.1, 100.0)
        return Triangle(a,b,c)
    }

}


fun main()
{

}
