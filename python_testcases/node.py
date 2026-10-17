class Node:
    def __init__(
        self,
        value=None,
        successor=None,
        successors=None,
        predecessors=None,
        incoming_nodes=None,
        outgoing_nodes=None,
    ):
        self.value = value
        self.successor = successor
        self.successors = [] if successors is None else successors
        self.predecessors = [] if predecessors is None else predecessors
        self.incoming_nodes = [] if incoming_nodes is None else incoming_nodes
        self.outgoing_nodes = [] if outgoing_nodes is None else outgoing_nodes
