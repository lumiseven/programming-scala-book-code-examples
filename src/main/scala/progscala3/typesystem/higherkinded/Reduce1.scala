// src/main/scala/progscala3/typesystem/higherkinded/Reduce1.scala
package progscala3.typesystem.higherkinded

trait Reduce1[-M[_]] {                                               // <1>
  def reduce[T](m: M[T])(f: (T, T) => T): T
}

object Reduce1 {                                                     // <2>
  implicit val seqReduce: Reduce1[Seq] = new Reduce1[Seq] {
    def reduce[T](seq: Seq[T])(f: (T, T) => T): T = seq reduce f
  }

  implicit val optionReduce: Reduce1[Option] = new Reduce1[Option] {
    def reduce[T](opt: Option[T])(f: (T, T) => T): T = opt.iterator reduce f
  }
}
