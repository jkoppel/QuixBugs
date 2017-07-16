
def shortest_path_length(length_by_edge, startnode, goalnode):
    unvisited_nodes = MinHeap() # FibHeap containing (node, distance) pairs
    unvisited_nodes.insert(startnode, 0)
    visited_nodes = set()

    while len(unvisited_nodes) > 0:
        node, distance = unvisited_nodes.pop()
        if node is goalnode:
            return distance

        visited_nodes.add(node)

        for nextnode in node.outgoing_nodes:
            if nextnode in visited_nodes:
                continue

            unvisited_nodes.insert_or_update(
                nextnode,
                min(
                    unvisited_nodes.get(nextnode) or float('inf'),
                    distance + length_by_edge[node, nextnode]
                )
            )

    return float('inf')

"""
def shortest_path_length(length_by_edge, startnode, goalnode):
    unvisited_nodes = MinHeap() # FibHeap containing (node, distance) pairs
    unvisited_nodes.insert(startnode, 0)
    visited_nodes = set()

    while len(unvisited_nodes) > 0:
        node, distance = unvisited_nodes.pop()
        if node is goalnode:
            return distance

        visited_nodes.add(node)

        for nextnode in node.outgoing_nodes:
            if nextnode in visited_nodes:
                continue

            unvisited_nodes.insert_or_update(
                nextnode,
                min(
                    unvisited_nodes.get(nextnode) or float('inf'),
                    length_by_edge[node, nextnode] + distance
                )
            )

    return float('inf')
"""

