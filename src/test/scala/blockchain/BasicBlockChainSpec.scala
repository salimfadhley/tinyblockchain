package blockchain

import org.scalatest.{FlatSpec, Matchers}

class BasicBlockChainSpec extends FlatSpec with Matchers{

  "BasicBlockChain" should "be creatable" in {
    val bc = new BasicBlockChain()
    bc.length should be(0)
  }

  it should "be initializable" in {
    val bc = new BasicBlockChain()
    bc.add_genesis_block
    bc.length should be(1)
  }

}
