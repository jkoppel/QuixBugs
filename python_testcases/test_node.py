from node import Node


def test_default_lists_are_not_shared():
    a = Node("a")
    b = Node("b")
    a.successors.append(b)
    a.predecessors.append(b)
    a.incoming_nodes.append(b)
    a.outgoing_nodes.append(b)

    assert b.successors == []
    assert b.predecessors == []
    assert b.incoming_nodes == []
    assert b.outgoing_nodes == []
