@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get">
            <input type="search" name="term" value=""/>
            <input type="submit" value="Search" />
        </form>
        @for(var user : page.getUsers())
            <div>${user.getFirstName()}  ${user.getLastName()}</div>
        @endfor
    `
)