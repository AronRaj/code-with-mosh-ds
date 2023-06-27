import java.lang.IllegalArgumentException

class Graph {

    val adjacencyList: HashMap<Node, MutableList<Node>> = LinkedHashMap()
    val nodes: HashMap<String, Node> = HashMap()

    class Node {
        private val label: String


        constructor(label: String) {
            this.label = label
        }

        override fun toString(): String {
            return "Node: ${this.label}"
        }
    }

    fun addNode(label: String) {
        val node = Node(label)
        nodes.putIfAbsent(label, node)
        adjacencyList.putIfAbsent(node, mutableListOf())
    }

    fun removeNode(label: String) {
        val removeNode = nodes[label] ?: return

        // since we're removing the entire node, we need to remove all the edges pointing towards this node.
        // for each node in out graph (adjacency list) we remove the node from each node. (removing edges to this node.)
        adjacencyList.keys.forEach { node -> adjacencyList[node]?.remove(removeNode) }
        // removing the nodes itself from the graph (adjacency list)
        adjacencyList.remove(removeNode)
        // removing the node from the list of nodes we're using to keep track of which ones exist in our graph.
        nodes.remove(label)
    }

    fun addEdge(from: String, to: String) {
        val fromNode = nodes[from] ?: throw IllegalArgumentException()
        val toNode = nodes[to] ?: throw IllegalArgumentException()
        adjacencyList[fromNode]?.add(toNode)
    }

    fun removeEdge(from: String, to: String) {
        val fromNode = nodes[from] ?: return
        val toNode = nodes[to] ?: return
        adjacencyList[fromNode]?.remove(toNode)
    }

    fun print() {
        adjacencyList.keys.forEach { node ->
            println("$node is connected to ${adjacencyList[node]}")
        }
    }

    // Recursive depth-first search
    fun traverseDepthFirst(label: String) {
        val node = nodes[label] ?: return
        traverseDepthFirst(node, HashSet())
    }

    fun traverseDepthFirst(node: Node, visitedNodes: HashSet<Node>) {
        println("Visited: $node")
        visitedNodes.add(node)
        adjacencyList[node]?.forEach { node ->
            if (!visitedNodes.contains(node))
                traverseDepthFirst(node, visitedNodes)
        }
    }
}