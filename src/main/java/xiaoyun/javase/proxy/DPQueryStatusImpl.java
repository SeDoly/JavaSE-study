package xiaoyun.javase.proxy;

public class DPQueryStatusImpl implements PDQueryStatus {
	@Override
	public DPFileStatus getFileStatus(String filename) {
		DPFileStatus status=new DPFileStatus(filename);
		System.out.println("Method getFileStatus Called, return: "+status);
		return status;
	}
}