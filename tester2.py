# make classes for extra classes and then just parse them in
# make version for proper programs

import copy
import json
import sys
import subprocess
import types

def py_try(algo,*args):
    module = __import__("python."+algo)
    fx = getattr(module, algo)

    if algo[-4:] == "GOOD":
        algo = algo[:-4]

    try:
        return getattr(fx,algo)(*args)
    except:
        return sys.exc_info()


def prettyprint(o):
    if isinstance(o, types.GeneratorType):
        return("(generator) " + str(list(o)))
    else:
        return(str(o))

if __name__ == "__main__":
    algo = sys.argv[1]
    working_file = open("json_testcases/"+algo+".json", 'r')

    for line in working_file:
        py_testcase = json.loads(line)
        print(py_testcase)
        test_in, test_out = py_testcase
        if not isinstance(test_in, list):
            # input is required to be a list, as multiparameter algos need to deconstruct a list of parameters
            # should fix in testcases, force all inputs to be list of inputs
            test_in = [test_in]
            # unsure how to make immutable; previous versions just used copy.deepcopy

        # check good Python version
        py_out_good = py_try(algo+"GOOD", *copy.deepcopy(test_in))
        print("Correct Python: " + prettyprint(py_out_good))

        # check bad Python version
        py_out_test = py_try(algo, *copy.deepcopy(test_in))
        print("Bad Python: " + prettyprint(py_out_test))

        # check bad Java version
        try:
            p1 = subprocess.Popen(["/usr/bin/java", "JavaDeserialization", algo]+ \
                                [json.dumps(arg) for arg in copy.deepcopy(test_in)], stdout=subprocess.PIPE)
            java_out = p1.stdout.read()
            print("Bad Java:   " + prettyprint(java_out)[2:-3])
        except:
            print("Bad Java:   " + prettyprint(sys.exc_info()))

        print()
        print()
