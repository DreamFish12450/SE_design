/**
 * this contains components which are frequently used.
 */

Vue.component('blank-view', {
    template: `
  	<section>
        <div class="jumbotron bg-transparent">
            <h1 class="display-4">请登录后再访问该页面</h1>
            <a href="login.html" class="btn btn-primary">登录</a>
        </div>
    </section>
    `
})

let index = window.location.href.lastIndexOf("\/")
window.str = window.location.href.substring(index + 1, window.location.href.length)
window.ppath = window.location.href.substring(0, index)

/**
 * 整个app框架
 */
Vue.component('app', {
    props: ['info', 'state'],
    created(){
        console.log(2233)
        $.ajax({
            type: 'post',
            // ansyv:true,
            cache: false,
            data: {},
            url: `${window.location.href.substring(0,index)}/init.do`,
            success: function (data) {
                console.log(data)
                document.getElementsByClassName("h4")[0].innerText=data.username


            }
        })

    },
    methods: {
        logout: function () {
            window.location.assign(`${window.ppath}/inite.jsp`)
        },


    },
    template: `
      <div class="page">
      <!-- Main Navbar-->
      <header class="header">
        <nav class="navbar">
          <!-- Search Box-->
          <div class="search-box">
            <button class="dismiss"><i class="icon-close"></i></button>
            <form id="searchForm" action="#" role="search">
              <input type="search" placeholder="What are you looking for..." class="form-control">
            </form>
          </div>
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!-- Navbar Header-->
              <div class="navbar-header">
                <!-- Navbar Brand --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                <div class="brand-text d-none d-lg-inline-block">
                  <strong>让停车更从容</strong></div>
                <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>停车</strong></div>
              </a>
                <!-- Toggle Button--><a id="toggle-btn" href="#"
                                        class="menu-btn active"><span></span><span></span><span></span></a>
              </div>
              <!-- Navbar Menu -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                <!-- Logout    -->
                <li class="nav-item"><a v-on:click="logout" class="nav-link logout"> <span
                    class="d-none d-sm-inline">Logout</span><i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch">
        <!-- Side Navbar -->
        <nav class="side-navbar">
          <!-- Sidebar Header-->
          <div class="sidebar-header d-flex align-items-center">

            <div class="title">
              <h1 class="h4"> </h1>
            </div>
          </div>
          <!-- Sidebar Navidation Menus-->
          <span class="heading">Main</span>
          <ul class="list-unstyled">
          
            <!-- 与书籍有关的三个相关界面，查找功能类似，在订阅功能上略有区别 -->
            <li>
              <a href="orderBook.html"><i class="icon-flask"></i>个人信息</a>
            </li>
            <li>
              <a href="${window.ppath}/showpersonalfee.jsp"><i class="icon-flask"></i>账单查询</a>
            </li>
            <li>
              <a href="${window.ppath}/chooseCar.jsp"><i class="icon-flask"></i>出行模块</a>
            </li>
            <li>
              <a href="${window.ppath}/charge.jsp"><i class="icon-flask"></i>充值模块</a>
            </li>

            <!-- 管理员的相关界面 -->
            <li v-if="state.type.role === 'admin'"><a href="#dropDown2" aria-expanded="false" data-toggle="collapse">
              <i class="icon-interface-windows"></i>学院管理</a>
              <ul id="dropDown2" class="collapse list-unstyled">
                <li :class="info.menu === 'admin_add_book' ? 'active': ''"><a href="adminAddBook.html">添加书籍</a>
                </li>
                <li :class="info.menu === 'admin_add_course' ? 'active': ''"><a href="addCourse.html">添加课程</a>
                </li>
                <li :class="info.menu === 'admin_open_course' ? 'active' : ''"><a href="admin_open_course.html">开设课程</a>
                </li>
              </ul>
            </li>
     
        </nav>
        <div class="content-inner" id="main-content">
          <header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">
              </h2>
            </div>
          </header>
          <blank-view v-if="state.status === false && state.tip !== '正在加载中...'"></blank-view>
          <slot v-else></slot>
          <!-- Page Footer-->
          <footer class="main-footer">
            <div class="container-fluid">
              <div class="row">
                <div class="col-sm-6">
                  <p>Copyright &copy; 2019.Company name All rights reserved.<a target="_blank"
                                                                               href="https://www.otsp.top">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
                  </p>
                </div>
                <div class="col-sm-6 text-right">
                  <p></p>
                  <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                </div>
              </div>
            </div>
          </footer>
        </div>
      </div>
      </div>`
})

/**
 * Form表单，有属性title
 */
Vue.component('form-card', {
    props: ['title'],
    template: `
      <div class="card">
      <div class="card-header d-flex align-items-center">
        <h3 class="h4">{{ title }}</h3>
      </div>
      <div class="card-body">
        <div class="form-horizontal">
          <slot></slot>
        </div>
      </div>
      </div>`
});
Vue.component('carCard', {
    props: ['carNumber', 'carModel'],
    template: `
        <div class="col-lg-4">
            <div class="work-amount card">
                <div class="card-close">
                    <div class="dropdown">
                        <button type="button" id="closeCard1" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i>
                        </button>
                        <div aria-labelledby="closeCard1" class="dropdown-menu dropdown-menu-right has-shadow"><a
                            href="#" class="dropdown-item remove"><i class="fa fa-times"></i>Close</a><a
                            href="#" class="dropdown-item edit"><i class="fa fa-gear"></i>Edit</a></div>
                    </div>
                </div>
                <div class="card-body"><h3>车牌为{{carNumber}}</h3><small></small>
                    <div class="chart text-center">
                        <div class="chartjs-size-monitor"
                             style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                            <div class="chartjs-size-monitor-expand"
                                 style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                                <div
                                    style="position: absolute; width: 100000px; height: 100000px; left: 0px; top: 0px;"></div>
                            </div>
                            <div class="chartjs-size-monitor-shrink"
                                 style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                                <div style="position: absolute; width: 200%; height: 200%; left: 0px; top: 0px;"></div>
                            </div>
                        </div>
                        <img src="img/car.png" width="200px" height="200px"></div>
                </div>
            </div>
        </div>
      `
})

/**
 * Form表单空间组，有属性label
 */
Vue.component('form-group', {
    props: ['label'],
    template: `
      <div class="form-group row">
      <label class="col-sm-3 form-control-label">{{ label }}</label>
      <div class="col-sm-9">
        <slot></slot>
      </div>
      </div>`
})
