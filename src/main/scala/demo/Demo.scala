import scala.io.Source

case class Order(orderId: String, userName: String, orderTime: Long, orderType: String, quantity: Int, price: Int)

object MatchingEngine {
  var orderBook: List[Order] = List.empty
  var matchedOrders: List[(Order, Order)] = List.empty

  def main(args: Array[String]): Unit = {
    val csvFilePath = "Book1.csv"
    val orders = {
      readOrdersFromCsv("C:/Users/pulic/Downloads/Book1.csv")
    }
    matchOrders(orders)
    printMatchedOrders()
  }

  def readOrdersFromCsv(filePath: String): List[Order] = {
    val lines = Source.fromFile(filePath).getLines().toList.tail
    lines.map { line =>
      val Array(orderId, userName, orderTime, orderType, quantity, price) = line.split(",")
      Order(orderId, userName, orderTime.toLong, orderType, quantity.toInt, price.toInt)
    }
  }

  def matchOrders(orders: List[Order]): Unit = {
    orders.foreach { order =>
      val matchingOrder = findMatchingOrder(order)
      matchingOrder match {
        case Some(matched) =>
          matchedOrders = (order, matched) :: matchedOrders
          orderBook = orderBook.filterNot(_ == matched)
        case None =>
          orderBook = order :: orderBook
      }
    }
  }

  def findMatchingOrder(order: Order): Option[Order] = {
    val matchingOrders = orderBook.filter { existingOrder =>
      existingOrder.orderType != order.orderType &&
        existingOrder.quantity == order.quantity
    }

    if (matchingOrders.nonEmpty) {
      val bestPriceOrder = matchingOrders.minBy(_.price)
      Some(bestPriceOrder)
    } else {
      None
    }
  }

  def printMatchedOrders(): Unit = {
    matchedOrders.foreach { case (order1, order2) =>
      println(s"Matched Orders: ${order1.orderId} - ${order2.orderId}")
      println(s"Price: ${order1.price}, Quantity: ${order1.quantity}")
      println()
    }
  }
}


