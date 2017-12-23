package blockchain

trait BlockFactory[B <: Block] {
  def genesis_block: B
  def create_block(index:Int, previousHash:String, data:String):B
  type blockType = B
}