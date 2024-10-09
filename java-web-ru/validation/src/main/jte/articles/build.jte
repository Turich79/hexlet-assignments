@import exercise.dto.articles.BuildArticlePage
  @param BuildArticlePage page

  @if(page.getErrors() != null)
      <ul>
          @for(var validator : page.getErrors().values())
              @for(var error : validator)
                  <li>${error.getMessage()}</li>
              @endfor
          @endfor
      </ul>
  @endif
<meta charset="utf-8" />
<form action="/articles" method="post">
  <div>
    <label>
      Название статьи
      <input type="text" name="title" value="${page.getTitle()}" />
    </label>
  </div>
  <div>
    <label>
      Содержание статьи
      <input type="textarea" required name="content" value="${page.getContent()}" />
    </label>
  </div>
  <input type="submit" value="Добавить статью" />
</form>