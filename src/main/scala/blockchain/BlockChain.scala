package blockchain

import scala.collection.mutable

trait BlockChain[B <: Block] {
  val chain = mutable.MutableList[B]()
  def add_block(b:B) = chain += b
  def dump:Iterator[B] = chain.iterator
  def length: Int = chain.length
  def add_block(data:String)
  def add_genesis_block()
  def last_block_index: Option[Int] = length match {
    case 0 => None
    case x => Some(x - 1)
  }
  def last_block: Option[B] = chain match {
    case _ :+ tail => Some(tail)
    case _ => None
  }
}
