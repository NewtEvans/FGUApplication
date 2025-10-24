const LoadingSpinner = () => {
    return (
        <div className="d-flex flex-column justify-content-center align-items-center vh-100">
            <div className="spinner-border text-primary mb-3 "/>
            <strong>NAČÍTÁM DATA</strong>
        </div>
    );
}

export default LoadingSpinner;