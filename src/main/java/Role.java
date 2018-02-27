public class Role {

    private boolean canDelete;
    private boolean canPost;
    private boolean canBlacklist;
    private String roleName;

    public Role(Boolean canDelete, Boolean canPost, Boolean canBlacklist, String roleName) {
        this.canDelete = canDelete;
        this.canPost = canPost;
        this.canBlacklist = canBlacklist;
        this.roleName = roleName;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public Boolean getCanPost() {
        return canPost;
    }

    public Boolean getCanBlacklist() {
        return canBlacklist;
    }

    public String getRole() {
        return roleName;
    }
}
