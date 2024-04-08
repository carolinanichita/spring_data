package cn.spring_data.project.entity.projection;

public record CustomerFullName(String firstName, String lastName) {
    public String getFullName() {
        return lastName + " " + firstName;
    }
}
