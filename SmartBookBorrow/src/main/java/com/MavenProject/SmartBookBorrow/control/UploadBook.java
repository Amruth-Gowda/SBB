package com.MavenProject.SmartBookBorrow.control;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import com.MavenProject.SmartBookBorrow.config.Config;
import com.MavenProject.SmartBookBorrow.dao.BookDAO;
import com.MavenProject.SmartBookBorrow.model.Book;


@WebServlet("/UploadBook")
@MultipartConfig
public class UploadBook extends HttpServlet {
	private static final int serialVersionUID = 1;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			System.out.println("reached the servlet!!");
			Part filePart = request.getPart("bookImage");  // Retrieves <input type="file" name="bookImage">
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			
			// redirecting if chosen file is not jpg or jpeg
			String extension = FilenameUtils.getExtension(fileName);
			
			if(!extension.equalsIgnoreCase("jpg") && !extension.equalsIgnoreCase("jpeg") && !extension.equalsIgnoreCase("png")) {
				System.out.println("Not the supported type");
				response.sendRedirect("admin_add_book.jsp?s=invalidfile");
				return;
			}
			
			InputStream fileContent = filePart.getInputStream();
			File uploads = new File(Config.DATA_DIRECTORY);
			if (!uploads.exists())
				uploads.mkdir();

			File file = new File(uploads, fileName);
			if (file.exists())
				file.delete();

			Files.copy(fileContent, file.toPath());
			// getting the file path from where the data is stored
			String uploadedFilePath = Config.DATA_DIRECTORY + File.separator + fileName;
			
			Book book = new Book();
			book.setBookName(request.getParameter("bookName"));
			book.setBookDesc(request.getParameter("bookDesc"));
			book.setBookAuthor(request.getParameter("bookAuthor"));
			book.setBookImagePath(uploadedFilePath);
			book.setCanBuy(Integer.parseInt(request.getParameter("canBuy")));
			book.setCanBorrow(Integer.parseInt(request.getParameter("canBorrow")));
			
			BookDAO bookDao = BookDAO.getInstance();
			int res = bookDao.addBook(book);
			
			if (res != 0) {
				response.sendRedirect("admin_add_book.jsp?s=success");
				return;
			} else {
				response.sendRedirect("admin_add_book.jsp?s=failure");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("admin_add_book.jsp?s=error#upload_div");
		}
		
	}

}
