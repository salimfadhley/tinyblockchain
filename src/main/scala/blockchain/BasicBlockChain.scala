package blockchain

class BasicBlockChain extends BlockChain[BasicBlock] {
  override def add_block(data: String) = {
    last_block match {
      case Some(b) => add_block(BasicBlock.create_block(length, b.hash, data))
      case None => throw new CannotAddBlock("Cannot add a block to an empty blockchain.")
    }



  }

  override def add_genesis_block():Unit = add_block(BasicBlock.genesis_block)
}
