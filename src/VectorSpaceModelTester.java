
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * the tester class.
 * 
 * @author swapneel
 */
public class VectorSpaceModelTester {

	public static void main(String[] args) {

		Document d1 = new Document("frankenstein.txt");
		Document d2 = new Document("nightmare-abbey.txt");
		Document d3 = new Document("northanger_abbey");
		Document d4 = new Document("tom-sawyer.txt");
		Document d5 = new Document("michael_strogoff.txt");
		Document d6 = new Document("prime_minister.txt");
		Document d7 = new Document("oz.txt");
		Document d8 = new Document("broad_highway.txt");
		Document d9 = new Document("silver_sea.txt");

		ArrayList<Document> documents = new ArrayList<Document>();
		documents.add(d1);
		documents.add(d2);
		documents.add(d3);
		documents.add(d4);
		documents.add(d5);
		documents.add(d6);
		documents.add(d7);
		documents.add(d8);
		documents.add(d9);

		Corpus corpus = new Corpus(documents);

		VectorSpaceModel vectorSpace = new VectorSpaceModel(corpus);

		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter("CosSimilarity.csv");
			csvWriter.append("Country 1");
			csvWriter.append(",");
			csvWriter.append("Country 2");
			csvWriter.append(",");
			csvWriter.append("Cosine Similarity");
			csvWriter.append("\n");

			for (int i = 0; i < documents.size(); i++) {
				for (int j = i + 1; j < documents.size(); j++) {
					Document doc1 = documents.get(i);
					Document doc2 = documents.get(j);
					System.out.println("\nComparing " + doc1 + " and " + doc2);
					Double cosSim = vectorSpace.cosineSimilarity(doc1, doc2);
					System.out.println(cosSim);

					csvWriter.append(doc1.toString() + ",");
					csvWriter.append(doc2.toString() + ",");
					csvWriter.append(cosSim + "\n");
				}
			}
			
			csvWriter.flush();  
			csvWriter.close();  

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// for(int i = 1; i < documents.size(); i++) {
		// Document doc = documents.get(i);
		// System.out.println("\nComparing to " + doc);
		// System.out.println(vectorSpace.cosineSimilarity(query, doc));
		// }

	}

}
