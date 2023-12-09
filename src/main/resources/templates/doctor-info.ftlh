<#import "common/page.ftlh" as c>
    <#import "common/navbar.ftlh" as nav>

        <@c.page>

            <@nav.nav>
            </@nav.nav>

            <div style="width: 96%; margin: auto; padding: 10px;">
                <h3 class="card-text">${doctor.name}</h3>
                <div class="list" style="display: flex; flex-wrap: wrap; justify-content: center; width: fit-content">

                    <#list appointments as appointment>
                        <div class="card"
                            style="width: 16rem;  margin-top: 10px; margin-right: 10px; padding-bottom: 0px;">

                            <div class="card-body">

                                <h5 class="card-title">${appointment.getDate()}</h5>

                                <form class=" form-inline my-2 my-lg-0">
                                    <button type="button" class="modal-button btn btn-primary" data-toggle="modal"
                                        data-id="${appointment.id}" data-time="${appointment.getDate()}"
                                        data-target="#exampleModalCenter" style="width: fit-content;">Make an
                                        Appointment</button>
                                </form>


                            </div>
                        </div>
                        <#else>
                            <h3>Appointments not found</h3>
                    </#list>
                </div>
            </div>



            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Create an order</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div style="margin-bottom: 15px" id="timeText"></div>

                            <form action="/appointment/add/user" id="add" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <input type="hidden" id='appointmentid' name="appointmentId" value="">

                                <button type="submit" class="btn btn-primary">Make an Appointment</button>
                            </form style="margin-bottom=0px">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            </div>

            <script>
                const cardWrapper = document.querySelector(".list");
                const cardTitles = document.querySelectorAll(".card");

                cardWrapper.style = 'display: block;'

                cardWrapper.innerHTML = '';

                const dates = [];
                cardTitles.forEach(item => {
                console.log(dates);
                    const date = item.querySelector('.card-title').textContent.substr(0, 10);
                    if (dates.includes(date)) {
                        cardWrapper.lastElementChild.appendChild(item);
                    }
                    else {
                        dates.push(date);

                        const child = document.createElement("div");
                        cardWrapper.innerHTML += "<h4>" + date + "</h4>";
                        child.style = 'display: flex; flex-wrap: wrap; margin-bottom: 20px;';

                        cardWrapper.appendChild(child);

                        cardWrapper.lastElementChild.appendChild(item);
                    }

                })



                var exampleModal = document.getElementById('exampleModalCenter')
                var buttons = document.querySelectorAll('.modal-button')


                buttons.forEach(button => {
                    button.addEventListener('click', function (event) {
                        var recipient = button.getAttribute('data-id')
                        var time = button.getAttribute('data-time')

                        var modalTitle = exampleModal.querySelector('.modal-title')
                        var modalBodyInput = exampleModal.querySelector('#appointmentid')
                        var timeText = document.querySelector('#timeText')

                        modalTitle.textContent = 'New Appointment'
                        modalBodyInput.value = recipient
                        timeText.innerHTML =
                            "Are you sure you want to add an entry for " + time + "?"
                    })
                })

            </script>



        </@c.page>