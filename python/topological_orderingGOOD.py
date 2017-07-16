
def topological_ordering(nodes):
    ordered_nodes = OrderedSet(node for node in nodes if not node.incoming_nodes)

    for node in ordered_nodes:
        for nextnode in node.outgoing_nodes:
            if ordered_nodes.issuperset(nextnode.incoming_nodes):
                ordered_nodes.add(nextnode)

    return ordered_nodes
