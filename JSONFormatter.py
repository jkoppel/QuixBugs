'''
    The purpose of this python program is to format all the corresponding test cases into JSON format.
    Input: text files of testcases
    Output: JSON format of testcases
'''

import glob
import os
import json
import ast

testcasespath = 'testcases/'
jsonfiledirectory = 'json_testcases/'

def readTextFile(filename):
    with open(filename) as textfile:
        testcases = []
        for line in textfile:
            if line != '\n':
                testcase = ast.literal_eval(line)
                testcases.append(testcase)
    return testcases

def writeJSONFile(filename, testcases):
    newfilename = filename[len(testcasespath):-3] + 'json'
    for testcase in testcases:
        with open(jsonfiledirectory  + newfilename, 'a') as jsonfile:
            json.dump(testcase, jsonfile)
            jsonfile.write("\n")

def main():
    for file in glob.glob(os.path.join(testcasespath, "*.txt")):
        print('Converting ' + file[len(testcasespath):-4] + ' to json format.')
        testcases = readTextFile(file)
        writeJSONFile(file, testcases)

    print('Testcase conversion complete.')

if __name__ == '__main__':
    main()
