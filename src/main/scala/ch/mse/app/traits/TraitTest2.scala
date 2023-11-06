package ch.mse.app.traits

object TraitTest2 {
	
	trait C1 {
		def print = { println("C1:print"); foo }
		def foo = println("C1:foo")
	}
	
	trait T1 extends C1 {
		override def print = { println("T1:print"); super.print }
		override def foo = { println("T1:foo"); super.foo }
	}

	trait T2 extends C1 {
		override def print = { println("T2:print"); super.print }
	}

	trait T3 extends C1 {
		override def print = { println("T3:print"); super.print }
	}

	class C2 extends T2 {
		override def print = { println("C2:print"); super.print }
		override def foo = { println("C2:foo"); super.foo }
	}
	
	class C3 extends C2 with T1 with T2 with T3 {
		override def print = { println("C3:print"); super.print }
	}
	
	def main(args: Array[String]): Unit = {
		val c = new C3
		c.print
	}
}