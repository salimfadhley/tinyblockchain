package blockchain

import com.github.nscala_time.time.Imports._
import com.roundeights.hasher.{Algo, Foldable}

class BasicBlock(index:Int, timestamp:DateTime, previousHash:String, data:String) extends Block {

  def hash:String = {
    val toHash: List[String] = List(index.toString, timestamp.toString(), previousHash, data)
    toHash.foldLeft( Algo.sha256.foldable ){ case (ac: Foldable, value: String) => ac(value)}.done.hex
  }
}

object BasicBlock extends BlockFactory[Block] {
  override def genesis_block = create_block(0, "", "")

  override def create_block(index: Int, previousHash: String, data: String) = {
    new BasicBlock(index, DateTime.now(), previousHash, data)
  }
}
