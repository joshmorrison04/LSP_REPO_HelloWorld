**Assignment 3 Reflection**

**Difference in Design Between Assignments 2 and 3**

In Assignment 2, I implemented the ETL pipeline in a mostly procedural way using one main class (ETLPipeline) with static methods for extraction, transformation, and loading. The code worked, but all responsibilities were bundled together. For example, file reading, row transformations, and output writing were all handled inside one file. This made the design less modular and harder to extend.

In Assignment 3, I refactored the pipeline into a set of smaller, focused classes. Instead of one large class, I created separate interfaces (Extractor, Transformer, Loader) and concrete implementations (CsvExtractor, ProductTransform, CsvLoader). An EtlPipeline class coordinates the steps, and a simple App class provides the entry point. This separation gives each class a single clear responsibility, which makes the code easier to maintain and modify in the future.

**How Assignment 3 is More Object-Oriented** 

Assignment 3 is more object-oriented as it uses an object-oriented design. Each stage of the ETL process is represented by an object, and responsibilities are encapsulated within those classes. For example, CsvExtractor hides the details of reading from a CSV file, while CsvLoader hides the details of writing output. The pipeline itself doesn’t need to know how these steps are implemented, only that they follow the contracts defined by the interfaces.

This is an improvement over Assignment 2 because now I can change one part of the pipeline without rewriting the others. For instance, I could add a JsonExtractor or DatabaseLoader in the future by reusing the same pipeline structure.

**Object-Oriented Concepts Used**

* Object and class  
* Encapsulation  
* Polymorphism  
* Inheritance  
* Composition

**Testing**

To confirm that Assignment 3 produced the exact same outputs as Assignment 2, I ran both versions on the same input file (data/products.csv). At first, I noticed differences: Assignment 3 was writing the header row twice and skipping the first product row. After debugging, I fixed ProductTransform so that it matched Assignment 2’s behavior.

Finally, I verified correctness by running Assignment 2 and Assignment 3 one after the other and checking the resulting data/transformed\_products.csv. After the fixes, both assignments produced identical outputs. This confirmed that the new pipeline in Assignment 3 functions the same as the one in Assignment 2\.

