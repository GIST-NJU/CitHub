
<template>
    <aside class="sidenav bg-white navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-4 "
        id="sidenav-main">
        <div class="sidenav-header">
            <i class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none"
                aria-hidden="true" id="iconSidenav"></i>
            <div class="navbar-brand m-0">
                <img src="../../assets/img/logo-ct-dark.png" class="navbar-brand-img h-100" alt="main_logo">

                <span class="ms-1 font-weight-bold text-lg">CitHub Repositoy</span>
            </div>
        </div>
        <hr class="horizontal dark mt-0">
        <div class="collapse navbar-collapse  w-auto " id="sidenav-collapse-main">
            <ul class="navbar-nav">

                <li class="nav-item" @click="jumpToHome" style=" cursor:pointer;">
                    <a :class="['nav-link', isActiveHome ? 'active' : '']" @mouseover="handleMouseOverHome"
                        @mouseout="handleMouseOutHome">
                        <div
                            class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
                            <i class="ni ni-tv-2 text-primary text-lg opacity-10"></i>
                        </div>
                        <span class="nav-link-text ms-1 p">Home</span>
                    </a>
                </li>

                <li class="nav-item" @click="jumpToPapers" style=" cursor:pointer;">
                    <a :class="['nav-link', isActivePapers ? 'active' : '']" @mouseover="handleMouseOverPapers"
                        @mouseout="handleMouseOutPapers">
                        <div
                            class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
                            <i class="ni ni-calendar-grid-58 text-warning text-lg opacity-10"></i>
                        </div>
                        <span class="nav-link-text ms-1 p">Papers</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="../repository/category.html">
                        <div
                            class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
                            <i class="ni ni-credit-card text-success text-lg opacity-10"></i>
                        </div>
                        <span class="nav-link-text ms-1 p">Category</span>
                    </a>
                </li>
                <li class="nav-item" @click="jumpToScholars" style=" cursor:pointer;">
                    <a :class="['nav-link', isActiveScholars ? 'active' : '']" @mouseover="handleMouseOverScholars"
                        @mouseout="handleMouseOutScholars">
                        <div
                            class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
                            <i class="ni ni-bag-17 text-danger text-lg opacity-10"></i>
                        </div>
                        <span class="nav-link-text ms-1 p">Scholars</span>
                    </a>
                </li>
                <li class="nav-item" @click="jumpToInstitutions" style=" cursor:pointer;">
                    <a :class="['nav-link', isActiveInstitutions ? 'active' : '']" @mouseover="handleMouseOverInstitutions"
                        @mouseout="handleMouseOutInstitutions">
                        <div
                            class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">

                            <i class="ni ni-atom  text-primary text-lg opacity-10" aria-hidden="true"></i>
                        </div>
                        <span class="nav-link-text ms-1 p">Institutions</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="../repository/venue.html">
                        <div
                            class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
                            <i class="ni ni-building text-warning text-lg opacity-10"></i>
                        </div>
                        <span class="nav-link-text ms-1 p">Venue</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="../repository/rank.html">
                        <div
                            class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
                            <i class="ni ni-chart-bar-32 text-info text-lg opacity-10"></i>
                        </div>
                        <span class="nav-link-text ms-1 p">Rank</span>
                    </a>
                </li>
            </ul>
        </div>
    </aside>
</template>

<script  setup>
import { useRouter } from 'vue-router';
import { ref } from 'vue';
const router = useRouter();


const isActiveHome = ref(false)
const isActivePapers = ref(false)
const isActiveScholars = ref(false)
const isActiveInstitutions = ref(false)



const jumpToHome = () => {
    router.push({ path: '/' })
}

const jumpToPapers = () => {
    // console.log("123")
    router.push({ path: '/Papers' })
}
const jumpToScholars = () => {
    router.push({ path: '/Scholars' })
}
const jumpToInstitutions = () => {
    router.push({ path: '/Institutions' })
}

const handleMouseOverHome = () => { isActiveHome.value = true; }
const handleMouseOutHome = () => { isActiveHome.value = false }

const handleMouseOverPapers = () => { isActivePapers.value = true; }
const handleMouseOutPapers = () => { isActivePapers.value = false }


const handleMouseOverScholars = () => { isActiveScholars.value = true; }
const handleMouseOutScholars = () => { isActiveScholars.value = false }

const handleMouseOverInstitutions = () => { isActiveInstitutions.value = true; }
const handleMouseOutInstitutions = () => { isActiveInstitutions.value = false }
</script>


<style scoped></style>
