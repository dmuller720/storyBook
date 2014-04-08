/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storybook.export;

import java.io.File;
import java.util.List;
import org.hibernate.Session;
import storybook.SbConstants;
import storybook.model.BookModel;
import storybook.model.hbn.dao.ChapterDAOImpl;
import storybook.model.hbn.dao.PartDAOImpl;
import storybook.model.hbn.dao.SceneDAOImpl;
import storybook.model.hbn.entity.Chapter;
import storybook.model.hbn.entity.Part;
import storybook.model.hbn.entity.Scene;
import storybook.toolkit.DocumentUtil;

/**
 *
 * @author favdb
 */
public class ExportBook {

	private final Export parent;
	private ExportHtml html;
	private ExportPDF pdf;
	private ExportCsv csv;
	private ExportTxt txt;
	private ExportOdf odf;
	private final BookExporter bookExporter;
	private final boolean isMultiHtml;
	private String baseFilename;

	public ExportBook(Export m) {
		parent = m;
		bookExporter = new BookExporter(m.mainFrame);
		baseFilename=parent.directory+File.separator;
		baseFilename+=DocumentUtil.restoreInternal(parent.mainFrame, SbConstants.InternalKey.TITLE, "").getStringValue();
		isMultiHtml=parent.parent.paramExport.htmlBookMulti;
	}
	
	public String get() {
		String rc = "";
		switch (parent.format) {
			case "html": html = new ExportHtml(parent, "Book", baseFilename+".html", null, parent.author); break;
			case "csv": break; // no export csv Book
			case "txt": txt = new ExportTxt(parent, "Book", baseFilename+".txt", null, parent.author); break;
			case "pdf": pdf = new ExportPDF(parent, "Book", baseFilename+".pdf", null, parent.author); break;
			case "odf": odf = new ExportOdf(parent, "Book", baseFilename+".odt", null, parent.author); break;
		}
		if (!isMultiHtml) {
			rc = debut();
			if (!"".equals(rc)) return (rc);
		}
		BookModel model = parent.mainFrame.getDocumentModel();
		Session session = model.beginTransaction();
		PartDAOImpl PartDAO = new PartDAOImpl(session);
		ChapterDAOImpl ChapterDAO = new ChapterDAOImpl(session);
		SceneDAOImpl SceneDAO = new SceneDAOImpl(session);
		List<Part> listParts = PartDAO.findAll();
		for (Part part : listParts) {
			getPart(part);
			List<Chapter> chapters = ChapterDAO.findAll(part);
			for (Chapter chapter : chapters) {
				getChapter(chapter, ChapterDAO);
				List<Scene> scenes = SceneDAO.findByChapter(chapter);
				for (Scene scene : scenes) {
					getScene(scene);
				}
			}
		}
		fin();
		if (isMultiHtml) {
			html = new ExportHtml(parent, "Book", baseFilename+" index.html", null, parent.author);
			html.open(false);
			for (Part part : listParts) {
				getTocPart(part);
				List<Chapter> chapters = ChapterDAO.findAll(part);
				for (Chapter chapter : chapters) {
					getTocChapter(chapter, ChapterDAO);
				}
			}
			html.close(false);
		}
		model.commit();
		return (rc);
	}

	public String debut() {
		String rc = "";
		switch (parent.format) {
			case "html":	html.open(false); break;
			case "csv":		csv.open(); break;//no header
			case "txt":		txt.open(); break;//no header
			case "pdf":		pdf.open(); break;
			case "odf":		odf.open(); break;
		}
		return (rc);
	}

	private void getPart(Part part) {
		switch (parent.format) {
			case "html":
				if (!isMultiHtml) {
					html.writeText(bookExporter.getPartAsHtml(part), false);
				}
				break;
			case "csv": break; // no csv export for book
			case "txt": txt.writeText(bookExporter.getPartAsTxt(part)); break;
			case "pdf": // TODO ExportBook PDF
				//pdf.writeText(str);
				break;
			case "odf": // TODO ExportBook ODF
				//odf.writeText(str);
				break;
		}
	}
	private String getChapterId(Chapter chapter) {
		String spart=Integer.toString(chapter.getPart().getNumber());
		String schapter=Integer.toString(chapter.getChapterno());
		if (spart.length()<2) spart="0"+spart;
		if (schapter.length()<2) schapter="0"+schapter;
		return(spart+"-"+schapter);
	}

	private void getChapter(Chapter chapter, ChapterDAOImpl ChapterDAO) {
		switch (parent.format) {
			case "html":
				if (isMultiHtml) {
					if (html.isOpened) html.close(false);
					html = new ExportHtml(parent, "Book", 
							baseFilename+" "+getChapterId(chapter)+".html", 
							null, parent.author);
					html.open(false);
				}
				html.writeText(bookExporter.getChapterAsHtml(chapter, ChapterDAO), false);
				break;
			case "csv": break; // no export csv Book
			case "txt": txt.writeText(bookExporter.getChapterAsTxt(chapter, ChapterDAO)); break;
			case "pdf":
				//pdf.writeText(str);
				break;
			case "odf":
				//odf.writeText(str);
				break;
		}
	}

	private void getScene(Scene scene) {
		switch (parent.format) {
			case "html": html.writeText(bookExporter.getSceneAsHtml(scene), false); break;
			case "csv": break; // no export csv Book
			case "txt": txt.writeText(bookExporter.getSceneAsTxt(scene)); break;
			case "pdf":
				//pdf.writeText(str);
				break;
			case "odf":
				//odf.writeText(str);
				break;
		}
	}

	private void fin() {
		switch (parent.format) {
			case "html": html.close(false); break;
			case "pdf": pdf.close(); break;
			case "csv": csv.close(); break;
			case "txt": txt.close(); break;
		}
	}

	private void getTocPart(Part part) {
		html.writeText("<h2>"+part.getNumberName()+"</h2>", false);
	}

	private void getTocChapter(Chapter chapter, ChapterDAOImpl ChapterDAO) {
		String str = "<a href=\"" 
				+ baseFilename + " "
				+ getChapterId(chapter) + ".html\">"
				+ chapter.getChapternoStr() + " " + chapter.getTitle()
				+ "</a><br>\n";
		html.writeText(str, false);
	}

}
