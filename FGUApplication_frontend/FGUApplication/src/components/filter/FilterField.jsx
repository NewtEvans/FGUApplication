export default function FilterField({name, label, type, register}) {
    return (
        <div className="mb-3">
            <label htmlFor={name} className="form-label">
                {label}
            </label>

            <input
                type={type}
                id={name}
                {...register(name)}
                className="form-control"
            />
        </div>
    );
}
