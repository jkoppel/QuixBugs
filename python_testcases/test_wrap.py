import pytest
from load_testdata import load_json_testcases

if pytest.use_correct:
    from correct_python_programs.wrap import wrap
else:
    from python_programs.wrap import wrap


testdata = load_json_testcases(wrap.__name__)


@pytest.mark.parametrize("input_data,expected", testdata)
def test_wrap(input_data, expected):
    assert wrap(*input_data) == expected


def test_wrap_leading_space():
    # After "hello" is cut off, the rest starts with a space, so rfind returns 0.
    assert wrap("hello world", 5) == ["hello", " ", "world"]
