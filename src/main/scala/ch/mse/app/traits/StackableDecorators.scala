package ch.mse.app.traits

object StackableDecorators {
  trait Writer {
    def write(arg: String): Unit
  }

  class ConsoleWriter extends Writer {
    def write(arg: String): Unit = println(arg)
  }

  class DataWriter(inner: Writer) extends Writer {
    def write(arg: String): Unit = inner.write(arg)
    def write(arg: Int): Unit = inner.write(s"$arg")
    def write(arg: Char): Unit = inner.write(s"$arg")
  }
  
  class BufferedWriter(inner: Writer) extends Writer {
    private var buffer: String = "";
    def write(arg: String): Unit = {
      buffer += arg
    }
    def flush(): Unit = {
      inner.write(buffer)
      buffer = ""
    }
  }
  
  def main(args: Array[String]): Unit = {
    val w = new DataWriter(new BufferedWriter(new ConsoleWriter))
    w.write(123)
    // w.flush()
  }
}