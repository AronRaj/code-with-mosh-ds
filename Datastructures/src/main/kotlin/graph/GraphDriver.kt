package graph

fun main(args: Array<String>) {
    val graphDriver = Graph()
    val flavour = "Flavour"
    val decoration = "Decoration"
    val icingOne = "Icing-1"
    val icingTwo = "Icing-2"
    val topBorder = "Top Border"
    val bottomBorder = "Bottom Border"
    val message = "Message"
    graphDriver.addNode(flavour)
    graphDriver.addNode(decoration)
    graphDriver.addNode(icingOne)
    graphDriver.addNode(icingTwo)
    graphDriver.addNode(topBorder)
    graphDriver.addNode(bottomBorder)
    graphDriver.addNode(message)

    graphDriver.addEdge(flavour,decoration)
    graphDriver.addEdge(decoration,icingOne)
    graphDriver.addEdge(icingOne,message)

    graphDriver.addEdge(icingTwo,topBorder)
    graphDriver.addEdge(topBorder,bottomBorder)
    graphDriver.addEdge(bottomBorder,message)

    //graphDriver.removeEdge(decoration,icingOne)
    //graphDriver.addEdge(decoration,icingTwo)

    //graphDriver.print()

    graphDriver.traverseDepthFirst(flavour)


}