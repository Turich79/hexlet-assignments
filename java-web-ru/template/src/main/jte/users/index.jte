@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
    <head>
        <meta charset="utf-8" />
    </head>
    <body>
        @if(page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного пользователя</p>
        @else
            @for(var user : page.getUsers())
               <div>
                   <h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
               </div>
            @endfor
        @endif
    </body>
</html>