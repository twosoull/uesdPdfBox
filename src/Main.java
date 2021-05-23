import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Main{
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		System.out.println("create Pdf Sample");
		
		String fileName = "123.pdf"; // pdf 네임
		String imageName = "C:\\dr\\123.jpg"; //이미지 네임
		
		
		try {
			PDDocument doc = new PDDocument(); //pdf 인스턴스 생성
			PDPage page = new PDPage(); //페이지 인스턴스 생성
			
			
			doc.addPage(page); //1번 페이지를 넣어준다
			
			PDImageXObject image = new PDImageXObject(doc);
			//이미지를 불러온다
			image = PDImageXObject.createFromFile(imageName, doc);
			
			PDPageContentStream content = new PDPageContentStream(doc,page);
			
			
			//pdf객체와 페이지 객체를 넣어준다
			
			content.drawImage((PDImageXObject) image, 80,500 ,200,250); // (이미지,위치x,위치y,크기x,크기y)
			
			content.beginText();
			
			content.setFont(PDType1Font.HELVETICA,26); //폰트이름과 크기를 설정
			
			content.moveTextPositionByAmount(250, 250); //글이 들어갈 좌표
			
			content.drawString("resistrationfrom");//내용
			content.endText();
			
			content.beginText();
		    content.setFont(PDType1Font.HELVETICA, 16);
		    content.moveTextPositionByAmount(80, 400); // 가장 첫줄에 들어가는 글
		    content.drawString("Name : ");
		    content.endText();
		        
		        
		    content.beginText();
		    content.setFont(PDType1Font.HELVETICA, 16);
		    content.moveTextPositionByAmount(80,350); //두번째 줄
		    content.drawString("Father Name : ");
		    content.endText();
		        
		    content.beginText();
		    content.moveTextPositionByAmount(80,300); //3번째 줄
		    content.drawString("DOB : ");
		    content.endText();
		    
		    
		    
		    
		    
			content.close();
			
			doc.save(fileName); //
			
			doc.close();//닫아줘야한다
			
			System.out.println("your file created in : " + System.getProperty("user.dir"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //saving as pdf file with name perm
			
		
		
	}
}