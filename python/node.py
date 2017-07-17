class Node:
    def __init__(self, value=None, successor=None, successors=None, predecessors=None):
        self.value = value
        self.successor = successor
        self.successors = successors
        self.predecessors = predecessors

    def successor(self):
        return self.successor

    def successors(self):
        return self.successors

    def predecessors(self):
        return self.predecessors