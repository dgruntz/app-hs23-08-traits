package ch.mse.app.traits

object StackableTraits {
  trait Writer {
    def write(arg: String): Unit = {}
  }

  class ConsoleWriter extends Writer {
    override def write(arg: String): Unit = println(arg)
  }

  trait DataWriter extends Writer {
    def write(arg: Int): Unit = write(s"$arg")
    def write(arg: Char): Unit = write(s"$arg")
  }
  
  trait BufferedWriter extends Writer {
    private var buffer: String = "";
    override def write(arg: String): Unit = {
      buffer += arg
    }
    def flush(): Unit = {
      super.write(buffer)
      buffer = ""
    }
  }
  
  def main(args: Array[String]): Unit = {
    val w = new ConsoleWriter with BufferedWriter with DataWriter
    w.write(123)
    w.flush()
  }
}