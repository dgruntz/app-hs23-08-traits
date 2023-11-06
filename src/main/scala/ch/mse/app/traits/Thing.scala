package ch.mse.app.traits

case class Thing(val n: Int) extends Ordered[Thing] {
   def compare(that: Thing) = n - that.n
}
