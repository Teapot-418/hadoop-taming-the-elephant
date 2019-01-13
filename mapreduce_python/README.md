# Demo Streaming API

Besides Hadoop's Java API, Hadoop offers *Hadoop Streaming*, which enables programmers to use other languages than Java to write MapReduce jobs. The only requirement for those languages is, that they have to be able to work with Unix standard input and output.

The handy iterator, which is used in Java's mapper output is not present in this case, key-group boundaries have to be ensured within the program.

This is a simple example written in Python, which relies on the darknet data used in the other parts of this tutorial as well.

This Python-MapReduce will count the number of offers with the same category, so we get an overview of categories and how often they are present in the dataset.

To run the MapReduce job, call:

```shell
hadoop jar $HADOOP_HOME/share/hadoop/tools/lib/hadoop-streaming-*.jar
	-files category_mapper.py,category_reducer.py
	-input <input-file>
	-output <output-name>
	-mapper category_mapper.py
	-reducer category_reducer.py
```

`<input-file>` is the dataset to work with and `<output-file>` defines where the results will be stored.