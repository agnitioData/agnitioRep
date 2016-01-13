import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.table.*;
import com.microsoft.azure.storage.table.TableQuery.*;

public class MyTable {
	public static void main(String...s){
		String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=hrmsstorages;AccountKey=cL0VoFWFdrRgGa/mTD9ruvqCiyI49Kqlwfph0XXwCrAU/2E/DsBEuzAdvuvw7zTGjdbeeyzwBvgi5PenLjJbZg==;BlobEndpoint=https://hrmsstorages.blob.core.windows.net/;TableEndpoint=https://hrmsstorages.table.core.windows.net/;QueueEndpoint=https://hrmsstorages.queue.core.windows.net/;FileEndpoint=https://hrmsstorages.file.core.windows.net/";
		
		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		       CloudStorageAccount.parse(storageConnectionString);

		   // Create the table client.
		   CloudTableClient tableClient = storageAccount.createCloudTableClient();

		   // Create the table if it doesn't exist.
		   String tableName = "TableDemoByNitin";
		   CloudTable cloudTable = new CloudTable(tableName,tableClient);
		   cloudTable.createIfNotExists();
		   
		   // Create a new customer entity.
		    CustomerEntity customer1 = new CustomerEntity("soni", "ankita");
		    customer1.setEmail("ankita.soni@agnitio-technologies.com");
		    customer1.setPhoneNumber("+91-854796854");
		    
		    // Create an operation to add the new customer to the people table.
		    TableOperation insertCustomer1 = TableOperation.insertOrReplace(customer1);

		    // Submit the operation to the table service.
		    cloudTable.execute(insertCustomer1);
		    System.out.println("Entry Done.....");
		   
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		}
	}

}
