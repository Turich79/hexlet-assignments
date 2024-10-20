<!-- BEGIN -->
    rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/posts">Posts</a>
                    </li>
                </ul>
            </div>
        </nav>

        @if(page != null && page.getFlash() != null)
            <div class="alert alert-${page.getFlashType()}" role="alert">
                ${page.getFlash()}
            </div>
        @endif


        <div class="mx-auto p-4 py-md-5">
            ${content}
        </div>

    </body>
</html>
<!-- END -->
