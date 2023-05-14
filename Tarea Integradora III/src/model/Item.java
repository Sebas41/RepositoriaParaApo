package model;

public class Item {
    private String id;
	private String name;
    private int pagesNumber;
    private String publicationDate;
    private String url;
    private long readedPages;


    Item(String id, String name,int pagesNumber,String publicationDate,String url,long readedPages){
        super();
        this.id=id;
        this.name=name;
        this.pagesNumber=pagesNumber;
        this.publicationDate=publicationDate;
        this.url=url;
        this.readedPages=readedPages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getReadedPages() {
        return readedPages;
    }

    public void setReadedPages(long readedPages) {
        this.readedPages = readedPages;
    }


}
