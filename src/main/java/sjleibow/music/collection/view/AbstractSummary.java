package sjleibow.music.collection.view;

public abstract class AbstractSummary {
	
	protected static final String RESOURCE_LINK_FORMAT = "%s/%d";
	
	protected int id;
	protected String name;
	protected String resourceLink;
	
	public AbstractSummary(int id, String name) {
		this.id = id;
		this.name = name;
		this.resourceLink = String.format(RESOURCE_LINK_FORMAT, resourceName(), id);
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getResourceLink() {
		return resourceLink;
	}

	protected abstract String resourceName();
}
