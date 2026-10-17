
def wrap(text, cols):
    lines = []
    while len(text) > cols:
        end = text.rfind(' ', 0, cols + 1)
        if end == -1:
            end = cols
        elif end == 0:
            end = 1  # leading space: emit it alone, or the loop never advances
        line, text = text[:end], text[end:]
        lines.append(line)

    lines.append(text)
    return lines

